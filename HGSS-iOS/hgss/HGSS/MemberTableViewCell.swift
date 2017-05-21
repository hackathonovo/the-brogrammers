//
//  MemberTableViewCell.swift
//  HGSS
//
//  Created by Five on 20/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit

class MemberTableViewCell: UITableViewCell {


    @IBOutlet weak var btnCheck: UIButton!
    @IBOutlet weak var name: UILabel!
    @IBOutlet weak var skill: UILabel!
    
    var checked = false
    var username = "Init"
    
    func set(skill: String, name: String, username: String) {
        btnCheck.isEnabled = false
        self.name.text = name
        self.skill.text = skill
        self.username = username
    }
    
    func changeState()  {
        if !checked
        {
            checked = true
            btnCheck.setBackgroundImage(#imageLiteral(resourceName: "check"), for: .normal)
        }
        else
        {
            checked = false
            btnCheck.setBackgroundImage(#imageLiteral(resourceName: "uncheck"), for: .normal)
        }
    }
}
