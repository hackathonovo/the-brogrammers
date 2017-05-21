//
//  NavigationMenuViewController.swift
//  HGSS
//
//  Created by Five on 17/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit
import InteractiveSideMenu

class NavigationMenuViewController: MenuViewController {
    
    
    @IBOutlet weak var tableView: UITableView!
    
    override func viewDidLoad()
    {
        super.viewDidLoad()
        let nib = UINib(nibName: Constants.nibMenuCell, bundle: nil)
        let nibH = UINib(nibName: Constants.nibHederCell, bundle: nil)
        navigationController?.view.backgroundColor = .green
        tableView.register(nibH, forCellReuseIdentifier: Constants.nibHederCell)
        tableView.register(nib, forCellReuseIdentifier: Constants.nibMenuCell)
        tableView.delegate = self
        tableView.dataSource = self
        tableView.selectRow(at: IndexPath(row: 0, section: 0), animated: false, scrollPosition: UITableViewScrollPosition.none)
    }
}


extension NavigationMenuViewController: UITableViewDelegate, UITableViewDataSource {
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return Constants.items.count
    }
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let headerView = UIView()
        let headerCell = tableView.dequeueReusableCell(withIdentifier: Constants.nibHederCell) as! HederViewCell
        headerCell.setUp(name: AppDelegate.user.name!, lastname: AppDelegate.user.lastname!)
        headerView.addSubview(headerCell)
        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(self.tapGestureRecognizer(_:)))
        tapGesture.numberOfTouchesRequired = 1
        tapGesture.numberOfTapsRequired = 1
        headerView.addGestureRecognizer(tapGesture)
        return headerView
    }
    
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 100
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: Constants.nibMenuCell, for: indexPath) as! MenuViewCell
        cell.set(text: Constants.items[indexPath.row])
        return cell
    }
    
    func tapGestureRecognizer(_ gestureRecognizer: UIGestureRecognizer) {
        let user = AppDelegate.user
        DispatchQueue.main.async {
            guard let menuContainerViewController = self.menuContainerViewController else { return }
            let vc = UserInfoViewController()
            vc.setUp(name: user.name!, lastname: user.lastname!, username: user.username!, role: user.role!, skill: user.skill!, isAva: user.isAvailable)
            menuContainerViewController.selectContentViewController(vc)
            menuContainerViewController.hideMenu()
        }
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        DispatchQueue.main.async {
            guard let menuContainerViewController = self.menuContainerViewController else { return }
            menuContainerViewController.selectContentViewController(menuContainerViewController.contentViewControllers[indexPath.row])
            menuContainerViewController.hideMenu()
        }
    }
    

}
