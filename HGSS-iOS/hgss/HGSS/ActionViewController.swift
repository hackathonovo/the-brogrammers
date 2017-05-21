//
//  ActionViewController.swift
//  HGSS
//
//  Created by Five on 21/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit
import CoreLocation
import MapKit

class ActionViewController: UIViewController {

    @IBAction func goBack(_ sender: Any) {
        navigationController?.popViewController(animated: true)
    }
    @IBAction func openCaht(_ sender: Any) {
        navigationController?.pushViewController(ChatViewController(), animated: true)
    }
    
    var pin : MapPin?
    @IBOutlet weak var actionTitle: UILabel!
    @IBOutlet weak var mapView: MKMapView!
    @IBOutlet weak var owner: UILabel!
    @IBOutlet weak var decView: UITextView!
    let action: Action
    let users: [UserShow]
    let ns = NetworkService()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        AppDelegate.action = action
        decView.isEditable = false
        decView.text = action.description
        actionTitle.text = action.nameOfAction
        owner.text = action.owner
        pin = MapPin(coordinate: (action.location?.coordinate)!, title: "Početak akcije", subtitle: AppDelegate.user.lastname!)
        mapView.addAnnotation(pin!)
        for user in users
        {
            pin = MapPin(coordinate: CLLocationCoordinate2D(latitude: user.latitude, longitude: user.longitude) , title: action.nameOfAction, subtitle: user.username)
            mapView.addAnnotation(pin!)

        }
    }
    
    init(action: Action, users: [UserShow])
    {
        self.users = users
        self.action = action
        super.init(nibName:String(describing: ActionViewController.self), bundle: nil)
        
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

    @IBAction func joinAction(_ sender: Any)
    {
        ns.join(id: action.id)
        AppDelegate.pc = PushViewController()
        navigationController?.viewControllers = [AppDelegate.pc!]
        navigationController?.pushViewController(AppDelegate.pc!, animated: true)
    }
    
    @IBAction func updateAction(_ sender: Any)
    {
        navigationController?.pushViewController(UpdateActionViewController(action: action), animated: true)

    }
}
