//
//  UserShow.swift
//  HGSS
//
//  Created by Five on 21/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import Foundation

class UserShow
{
    let longitude: Double
    let latitude: Double
    let username: String
    
    init(longitude: Double, latitude: Double, username: String )
    {
        self.latitude = latitude
        self.longitude = longitude
        self.username = username
    }
}
