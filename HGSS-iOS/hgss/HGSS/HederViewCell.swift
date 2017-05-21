//
//  HederViewCell.swift
//  HGSS
//
//  Created by Five on 17/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit

class HederViewCell: UITableViewCell {

    @IBOutlet weak var lblName: UILabel!
    
    func setUp(name: String, lastname: String)
    {
        lblName.text = "\(name) \(lastname)"
    }
        
}
