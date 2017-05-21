//
//  ActionsViewController.swift
//  HGSS
//
//  Created by Five on 21/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit
import InteractiveSideMenu

class ActionsViewController: MenuItemContentViewController {

    @IBOutlet weak var tableView: UITableView!
    var actions = [Action]()
    let ns = NetworkService()
    let nc = NotificationCenter.default


    override func viewDidLoad() {
        super.viewDidLoad()
        let nib = UINib(nibName: Constants.actionCell, bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: Constants.actionCell)
        tableView.delegate = self
        tableView.dataSource = self
        nc.addObserver(forName:Notification.Name(rawValue:"Relode"),
                       object:nil, queue:nil,
                       using:relode)
        nc.addObserver(forName:Notification.Name(rawValue:"GoToAction"),
                       object:nil, queue:nil,
                       using:goToAction)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        actions = AppDelegate.actions
        tableView.reloadData()
    }
    
    func relode(notification: Notification){
        DispatchQueue.main.sync {
            tableView.reloadData()
        }
    }
    
    @IBAction func showMenu(_ sender: Any)
    {
        showMenu()
    }
    
    func goToAction(notification: Notification){
        guard let userInfo = notification.userInfo,
            let action  = userInfo["action"] as? Action,
            var users  = userInfo["users"] as? [UserShow] else {
                print("No userInfo found in notification")
                return
        }
        DispatchQueue.main.sync {
            navigationController?.pushViewController(ActionViewController(action: action, users: users), animated: true)
        }
    }
}

extension ActionsViewController: UITableViewDelegate, UITableViewDataSource
{
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return actions.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: Constants.actionCell, for: indexPath) as! ActionsViewCell
        cell.set(name: actions[indexPath.row].nameOfAction)
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath)
    {
        let cell = tableView.cellForRow(at: indexPath) as! ActionsViewCell
        ns.getAction(id: actions[indexPath.row].id)
    }

}
