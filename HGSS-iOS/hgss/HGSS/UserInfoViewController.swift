//
//  UserInfoViewController.swift
//  HGSS
//
//  Created by Five on 20/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit
import InteractiveSideMenu

class UserInfoViewController: MenuItemContentViewController
{
    @IBOutlet weak var lblUsername: UILabel!
    @IBOutlet weak var lblName: UILabel!
    @IBOutlet weak var lblLastname: UILabel!
    @IBOutlet weak var lblRole: UILabel!
    @IBOutlet weak var lblSkill: UILabel!
    @IBOutlet weak var svitchAva: UISwitch!
    
    var lblUsernametext  = "username"
    var lblNametext = "username"
    var lblLastnametext = "username"
    var lblRoletext = "username"
    var lblSkilltext = "username"
    
    let ns = NetworkService()
    
    override func viewDidLoad()
    {
        super.viewDidLoad()
        lblUsername.text  = lblUsernametext
        lblName.text = lblNametext
        lblLastname.text = lblLastnametext
        lblRole.text = lblRoletext
        lblSkill.text = lblSkilltext
    }
    
    override func viewWillAppear(_ animated: Bool) {
        svitchAva.isOn = AppDelegate.user.isAvailable
    }
    @IBAction func showMenu(_ sender: Any)
    {
        showMenu()
    }
    
    func setUp(name: String, lastname: String, username: String, role: String, skill: String, isAva: Bool)
    {
        lblUsernametext  = username
        lblNametext = name
        lblLastnametext = lastname
        lblRoletext = role
        lblSkilltext = skill
    }

    @IBAction func changeAva(_ sender: Any)
    {
        AppDelegate.user.isAvailable = svitchAva.isOn
        ns.changeAva(username: lblUsernametext, isAva: svitchAva.isOn)
    }
}
