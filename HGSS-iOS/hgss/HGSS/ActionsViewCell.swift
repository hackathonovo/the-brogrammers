//
//  ActionsViewCell.swift
//  HGSS
//
//  Created by Five on 21/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit

class ActionsViewCell: UITableViewCell {

    @IBOutlet weak var name: UILabel!
    
    func set(name: String)
    {
        self.name.text = name
    }

}
