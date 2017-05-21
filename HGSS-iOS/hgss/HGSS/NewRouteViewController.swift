//
//  NewRouteViewController.swift
//  HGSS
//
//  Created by Five on 19/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import CoreLocation
import HealthKit
import UIKit
import InteractiveSideMenu
import MapKit
import CoreData

class NewRouteViewController: MenuItemContentViewController {
    
    @IBOutlet weak var paceLabel: UILabel!
    @IBOutlet weak var distanceLabel: UILabel!
    @IBOutlet weak var timeLabel: UILabel!
    @IBOutlet weak var mapView: MKMapView!

    
    var focusOnUser = true
    var recording = false
    var mapPathCoordinates: [CLLocationCoordinate2D] = []
    let dataInsert = DataInsert()
    let ns = NetworkService()
    
    var currentPath: Path?
    var seconds = 0.0
    var distance = 0.0
    
    lazy var locationManager: CLLocationManager = {
        var _locationManager = CLLocationManager()
        _locationManager.delegate = self
        _locationManager.desiredAccuracy = kCLLocationAccuracyBest
        _locationManager.activityType = .fitness
        
        // Movement threshold for new events
        _locationManager.distanceFilter = 10.0
        return _locationManager
    }()
    
    lazy var locations = [CLLocation]()
    lazy var timer = Timer()

    override func viewDidLoad() {
        super.viewDidLoad()
        mapView.delegate = self
        mapView.showsUserLocation = true

    }
    
    override func viewWillAppear(_ animated: Bool) {
        locationManager.requestAlwaysAuthorization()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        timer.invalidate()
    }
    
    @IBAction func startPressed(_ sender: Any)
    {
        seconds = 0.0
        distance = 0.0
        locations.removeAll(keepingCapacity: false)
        timer = Timer.scheduledTimer(timeInterval: 1,
                                                       target: self,
                                                       selector: #selector(eachSecond(_:)),
                                                       userInfo: nil,
                                                       repeats: true)
        currentPath = dataInsert.newPath()
        recording = true
        startLocationUpdates()
    }
    

    @IBAction func stopPressed(_ sender: Any)
    {
        locationManager.stopUpdatingLocation()
        timer.invalidate()
    }
    
}

extension NewRouteViewController: CLLocationManagerDelegate
{
    func eachSecond(_ timer: Timer) {
        seconds += 1
        let secondsQuantity = HKQuantity(unit: HKUnit.second(), doubleValue: seconds)
        timeLabel.text = "Time: " + secondsQuantity.description
        let distanceQuantity = HKQuantity(unit: HKUnit.meter(), doubleValue: distance)
        distanceLabel.text = "Distance: " + distanceQuantity.description
        let paceUnit = HKUnit.second().unitDivided(by: HKUnit.meter())
        let paceQuantity = HKQuantity(unit: paceUnit, doubleValue: distance / seconds)
        paceLabel.text = "Pace: " + paceQuantity.description
    }
    
    func startLocationUpdates() {
        locationManager.startUpdatingLocation()
    }
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        for location in locations {
            if location.horizontalAccuracy < 20 && recording{
                ns.sendLocation(location: location.coordinate)
                mapPathCoordinates.append(location.coordinate)
                let polyline = MKPolyline(coordinates: &mapPathCoordinates, count: mapPathCoordinates.count)
                mapView.add(polyline)
                if self.locations.count > 0 {
                    distance += location.distance(from: self.locations.last!)
                    dataInsert.insertLocation(location: location, path: currentPath!)
                }
                self.locations.append(location)
            }
            if focusOnUser
            {
                let span: MKCoordinateSpan =  MKCoordinateSpanMake(0.01, 0.01)
                let region: MKCoordinateRegion = MKCoordinateRegionMake(location.coordinate, span)
                mapView.setRegion(region, animated: true)
            }
        }
    }
}

extension NewRouteViewController
{
     
}


extension NewRouteViewController: MKMapViewDelegate
{
    
    func mapView(_ mapView: MKMapView, rendererFor overlay: MKOverlay) -> MKOverlayRenderer {
        if overlay is MKPolyline {
            let polyLineRenderer = MKPolylineRenderer(overlay: overlay)
            polyLineRenderer.strokeColor = UIColor.blue
            polyLineRenderer.lineWidth = 4
            return polyLineRenderer
        }
        return MKPolylineRenderer()
        
    }
}







