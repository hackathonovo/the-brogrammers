//
//  NewActionViewController.swift
//  HGSS
//
//  Created by Five on 20/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import CoreLocation
import HealthKit
import UIKit
import InteractiveSideMenu
import MapKit
import CoreData

class NewActionViewController: MenuItemContentViewController
{
    @IBOutlet weak var map: MKMapView!
    @IBOutlet weak var actionDesc: UITextView!
    @IBOutlet weak var bottomDescConst: NSLayoutConstraint!
    @IBOutlet weak var btnProced: UIButton!
    @IBOutlet weak var nameOfAction: UITextField!
    
    var pin : MapPin?
    var isOnMap = false
    let netService = NetworkService()
    let nc = NotificationCenter.default
    
    override func viewDidLoad()
    {
        super.viewDidLoad()
        actionDesc.delegate = self
        actionDesc.textColor = .lightGray
        actionDesc.text = "Opis akcije..."
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
        let longPressRecogniser = UILongPressGestureRecognizer(target: self, action: #selector(handleLongPress(_:)))
        longPressRecogniser.minimumPressDuration = 1.0
        map.addGestureRecognizer(longPressRecogniser)
        nc.addObserver(forName:Notification.Name(rawValue:"ProcedToUsers"),
                       object:nil, queue:nil,
                       using:procedToUser)
    }
    
    
    @IBAction func proced(_ sender: Any)
    {
        btnProced.isEnabled = false
        if pin == nil || actionDesc.text == "Opis akcije..."
        {
            btnProced.isEnabled  = true
            let alert = UIAlertController(title: "Error", message: "Molim napišite opis akcije i odaberite lokaciju", preferredStyle: UIAlertControllerStyle.alert)
            alert.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
            self.present(alert, animated: true, completion: nil)
        }
        else{
            netService.initAction(location: (pin?.coordinate)!, desc: actionDesc.text, name: nameOfAction.text!)
        }
    }
    
    func procedToUser(notification: Notification)
    {
        guard let userInfo = notification.userInfo,
        var users  = userInfo["users"] as? [User] else {
                print("No userInfo found in notification")
                return
        }
        DispatchQueue.main.sync {
            users.remove(at: 0)
            navigationController?.pushViewController(RescueCrewViewController(users: users), animated: true)
        }
    }

    func handleLongPress(_ gestureRecognizer : UIGestureRecognizer){
        if gestureRecognizer.state != .began { return }
        
        let touchPoint = gestureRecognizer.location(in: map)
        let touchMapCoordinate = map.convert(touchPoint, toCoordinateFrom: map)
        if isOnMap{
            map.removeAnnotation(map.annotations.last!)
        }
        isOnMap = true
        pin = MapPin(coordinate: touchMapCoordinate, title: "Početak akcije", subtitle: AppDelegate.user.lastname!)
        map.addAnnotation(pin!)
    }
    
    func dismissKeyboard()
    {
        actionDesc.resignFirstResponder()
    }
}

extension NewActionViewController: UITextViewDelegate
{
    func textViewDidBeginEditing(_ textView: UITextView)
    {
        bottomDescConst.constant += 200
        if textView.text == "Opis akcije..."
        {
            textView.text = ""
            textView.textColor = .black
        }
        textView.becomeFirstResponder() //Optional
    }
    
    func textViewDidEndEditing(_ textView: UITextView)
    {
        bottomDescConst.constant -= 200
        if textView.text == ""
        {
            textView.text = "Opis akcije..."
            textView.textColor = .lightGray
        }
        textView.resignFirstResponder()
    }
}

