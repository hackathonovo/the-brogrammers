//
//  Action.swift
//  HGSS
//
//  Created by Five on 21/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import Foundation
import CoreLocation

class Action
{
    let id: Int
    let nameOfAction: String
    var owner: String?
    var description: String?
    var location: CLLocation?
    
    init(id: Int, nameOfAction: String) {
        self.id = id
        self.nameOfAction = nameOfAction
    }
    
    func setUp(owner: String, desc: String, location: CLLocation){
        self.owner = owner
        self.description = desc
        self.location = location
    }
}
