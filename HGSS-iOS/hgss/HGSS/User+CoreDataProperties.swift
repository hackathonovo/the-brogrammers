//
//  User+CoreDataProperties.swift
//  HGSS
//
//  Created by Five on 21/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import Foundation
import CoreData


extension User {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<User> {
        return NSFetchRequest<User>(entityName: "User")
    }

    @NSManaged public var lastname: String?
    @NSManaged public var name: String?
    @NSManaged public var role: String?
    @NSManaged public var skill: String?
    @NSManaged public var username: String?
    @NSManaged public var isAvailable: Bool
    @NSManaged public var cellNumber: Int32

}
