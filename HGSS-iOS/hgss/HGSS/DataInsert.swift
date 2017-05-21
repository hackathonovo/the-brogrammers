//
//  DataInsert.swift
//  HGSS
//
//  Created by Five on 20/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import Foundation
import CoreData
import CoreLocation

class DataInsert
{
    func insertLocation(location: CLLocation, path: Path)
    {
        let locationBase = NSEntityDescription.insertNewObject(forEntityName: Constants.locationClassName, into: DatabaseController.getContext()) as! Location
        locationBase.latitude = location.coordinate.latitude
        locationBase.longitude = location.coordinate.longitude
        locationBase.timestamp = location.timestamp as NSDate
    }
    
    func newPath()->Path
    {
        return NSEntityDescription.insertNewObject(forEntityName: Constants.pathClassName, into: DatabaseController.getContext()) as! Path
    }
}
