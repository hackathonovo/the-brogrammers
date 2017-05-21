//
//  UpdateActionViewController.swift
//  HGSS
//
//  Created by Five on 21/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit
import CoreLocation
import MapKit


class UpdateActionViewController: UIViewController {

    
    init(action: Action)
    {
        self.action = action
        super.init(nibName: String(describing: UpdateActionViewController.self), bundle: nil)
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    let action: Action
    var newLocation: CLLocationCoordinate2D?
    let netService = NetworkService()
    var isOnMap = true
    @IBOutlet weak var actionTitle: UITextField!
    @IBOutlet weak var mapView: MKMapView!
    @IBOutlet weak var desc: UITextView!
    @IBOutlet weak var bottomConst: NSLayoutConstraint!
    
    override func viewDidLoad()
    {
        super.viewDidLoad()
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
        actionTitle.text = action.nameOfAction
        desc.text = action.description
        let pin = MapPin(coordinate: (action.location?.coordinate)!, title: "Početak akcije", subtitle: AppDelegate.user.lastname!)
        mapView.addAnnotation(pin)
        let longPressRecogniser = UILongPressGestureRecognizer(target: self, action: #selector(handleLongPress(_:)))
        longPressRecogniser.minimumPressDuration = 1.0
        mapView.addGestureRecognizer(longPressRecogniser)
        desc.delegate = self
    }
    
    @IBAction func update(_ sender: Any)
    {
        netService.updateAction(location: newLocation!, desc: desc.text, name: actionTitle.text!, id: action.id)
        AppDelegate.pc = PushViewController()
        navigationController?.viewControllers = [AppDelegate.pc!]
        navigationController?.pushViewController(AppDelegate.pc!, animated: true)
    }

    func handleLongPress(_ gestureRecognizer : UIGestureRecognizer){
        if gestureRecognizer.state != .began { return }
        
        let touchPoint = gestureRecognizer.location(in: mapView)
        let touchMapCoordinate = mapView.convert(touchPoint, toCoordinateFrom: mapView)
        newLocation = touchMapCoordinate
        if isOnMap{
            mapView.removeAnnotation(mapView.annotations.last!)
        }
        isOnMap = true
        let pin = MapPin(coordinate: touchMapCoordinate, title: "Početak akcije", subtitle: AppDelegate.user.lastname!)
        mapView.addAnnotation(pin)
    }
    
    func dismissKeyboard()
    {
        desc.resignFirstResponder()
        actionTitle.resignFirstResponder()
    }
}

extension UpdateActionViewController: UITextViewDelegate
{
    func textViewDidBeginEditing(_ textView: UITextView)
    {
        bottomConst.constant += 200
        if textView.text == "Opis akcije..."
        {
            textView.text = ""
            textView.textColor = .black
        }
        textView.becomeFirstResponder()
    }
    
    func textViewDidEndEditing(_ textView: UITextView)
    {
        bottomConst.constant -= 200
        if textView.text == ""
        {
            textView.text = "Opis akcije..."
            textView.textColor = .lightGray
        }
        textView.resignFirstResponder()
    }
}


