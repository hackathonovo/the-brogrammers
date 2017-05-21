//
//  RescueCrewViewController.swift
//  HGSS
//
//  Created by Five on 20/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit

class RescueCrewViewController: UIViewController
{
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var btnGo: UIButton!
    let users: [User]?
    let netService = NetworkService()
    
    override func viewDidLoad()
    {
        super.viewDidLoad()
        let nib = UINib(nibName: Constants.nibMeberCell, bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: Constants.nibMeberCell)
        tableView.delegate = self
        tableView.dataSource = self

    }
    
    init(users: [User]){
        self.users = users
        super.init(nibName: String(describing: RescueCrewViewController.self), bundle: nil)
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    @IBAction func goAction(_ sender: Any)
    {
        var usernames = [String]()
        for cell in tableView.visibleCells
        {
            if (cell as! MemberTableViewCell).checked == true
            {
                usernames.append((cell as! MemberTableViewCell).username)
            }
        }
        netService.goAction(usernames: usernames)
        returnHome()
    }
    
    func returnHome()
    {
        AppDelegate.pc = PushViewController()
        navigationController?.viewControllers = [AppDelegate.pc!]
        navigationController?.pushViewController(AppDelegate.pc!, animated: true)
        let alert = UIAlertController(title: "Akcija", message: "Akcija je pokrenuta", preferredStyle: UIAlertControllerStyle.alert)
        alert.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
        self.present(alert, animated: true, completion: nil)
    }
}

extension RescueCrewViewController: UITableViewDelegate, UITableViewDataSource {
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return users!.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: Constants.nibMeberCell, for: indexPath) as! MemberTableViewCell
        cell.set(skill: (users?[indexPath.row].role)!, name: (users?[indexPath.row].name)!+" "+(users?[indexPath.row].lastname)!, username: (users?[indexPath.row].username)!)
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath)
    {
        let cell = tableView.cellForRow(at: indexPath) as! MemberTableViewCell
        cell.changeState()
    }

}
