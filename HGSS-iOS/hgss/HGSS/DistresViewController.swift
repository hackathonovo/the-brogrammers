//
//  DistresViewController.swift
//  HGSS
//
//  Created by Five on 21/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit
import InteractiveSideMenu
import MessageUI
import CoreLocation

class DistresViewController: MenuItemContentViewController, MFMessageComposeViewControllerDelegate
{
    var mapPathCoordinates: [CLLocationCoordinate2D] = []

    @IBOutlet weak var btnDisters: UIButton!
    
    lazy var locationManager: CLLocationManager = {
        var _locationManager = CLLocationManager()
        _locationManager.delegate = self
        _locationManager.desiredAccuracy = kCLLocationAccuracyBest
        _locationManager.activityType = .fitness
        
        // Movement threshold for new events
        _locationManager.distanceFilter = 10.0
        return _locationManager
    }()
    
    override func viewWillAppear(_ animated: Bool) {
        locationManager.requestAlwaysAuthorization()
    }
    
    override func viewDidLoad() {
        btnDisters.layer.cornerRadius = 15
        super.viewDidLoad()
        locationManager.startUpdatingLocation()
    }
    
    @IBAction func sendText(_ sender: Any)
    {
        if (MFMessageComposeViewController.canSendText()) {
            let controller = MFMessageComposeViewController()
            controller.body = "\((locationManager.location?.coordinate.latitude)!), \((locationManager.location?.coordinate.longitude)!)"
            controller.recipients = ["+385995109450"]
            controller.messageComposeDelegate = self
            self.present(controller, animated: true, completion: nil)
        }
    }
    
    @IBAction func showMenu(_ sender: Any)
    {
        showMenu()
    }
    
    func messageComposeViewController(_ controller: MFMessageComposeViewController!, didFinishWith result: MessageComposeResult) {
        switch (result.rawValue) {
        case MessageComposeResult.sent.rawValue:
            print("Message was sent")
            self.dismiss(animated: true, completion: nil)
        default:
            break;
        }
        self.dismiss(animated: true, completion: nil)
        AppDelegate.pc = PushViewController()
        navigationController?.viewControllers = [AppDelegate.pc!]
        navigationController?.pushViewController(AppDelegate.pc!, animated: true)
    }

}

extension DistresViewController: CLLocationManagerDelegate
{
    
}
