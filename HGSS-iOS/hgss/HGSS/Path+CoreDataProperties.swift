//
//  Path+CoreDataProperties.swift
//  HGSS
//
//  Created by Five on 20/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import Foundation
import CoreData


extension Path {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<Path> {
        return NSFetchRequest<Path>(entityName: "Path")
    }

    @NSManaged public var attribute: String?
    @NSManaged public var timestamp: NSDate?
    @NSManaged public var locations: NSSet?

}

// MARK: Generated accessors for locations
extension Path {

    @objc(addLocationsObject:)
    @NSManaged public func addToLocations(_ value: Location)

    @objc(removeLocationsObject:)
    @NSManaged public func removeFromLocations(_ value: Location)

    @objc(addLocations:)
    @NSManaged public func addToLocations(_ values: NSSet)

    @objc(removeLocations:)
    @NSManaged public func removeFromLocations(_ values: NSSet)

}
