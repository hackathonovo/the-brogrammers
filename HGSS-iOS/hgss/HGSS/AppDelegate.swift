//
//  AppDelegate.swift
//  HGSS
//
//  Created by Five on 17/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?
    static var user = User()
    static var actions = [Action]()
    static var pc: PushViewController?
    static var action: Action?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
        window = UIWindow(frame: UIScreen.main.bounds)
        let viewController = LoginViewController()
        let navigationController = UINavigationController(rootViewController: viewController)
        navigationController.setNavigationBarHidden(true, animated: false)
        window?.rootViewController = navigationController
        window?.makeKeyAndVisible()
        return true
    }
    
}

