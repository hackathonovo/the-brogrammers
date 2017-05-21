//
//  PushViewController.swift
//  HGSS
//
//  Created by Five on 17/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit
import InteractiveSideMenu

class PushViewController: MenuContainerViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        menuViewController = NavigationMenuViewController()
        contentViewControllers = contentControllers()
        selectContentViewController(contentViewControllers.first!)
    }
    
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .default
    }
    
    override func menuTransitionOptionsBuilder() -> TransitionOptionsBuilder? {
        return TransitionOptionsBuilder() { builder in
            builder.duration = 0.5
            builder.contentScale = 1
        }
    }
    
    private func contentControllers() -> [MenuItemContentViewController] {
        var contentList = [MenuItemContentViewController]()
        contentList.append(MainViewController())
        contentList.append(NewActionViewController())
        contentList.append(ActionsViewController())
        contentList.append(DistresViewController())
        return contentList
    }

}
