//
//  LoginViewController.swift
//  HGSS
//
//  Created by Five on 20/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController
{
    @IBOutlet weak var textUsername: UITextField!
    @IBOutlet weak var textPassword: UITextField!
    @IBOutlet weak var btnLogin: UIButton!
    let loginService = LoginService()
    let nc = NotificationCenter.default
    
    override func viewDidLoad()
    {
        super.viewDidLoad()
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
        let myColor : UIColor = UIColor( red: 22, green: 119, blue:179, alpha: 1.0 )
        textPassword.layer.borderColor = myColor.cgColor
        nc.addObserver(forName:Notification.Name(rawValue:"LoginSuccess"),
                       object:nil, queue:nil,
                       using:loginSuccessNotification)
    }


    @IBAction func login(_ sender: Any)
    {
        btnLogin.isEnabled = false
        loginService.loginPost(username: textUsername.text!, password: textPassword.text!)
    }
    
    func loginSuccessNotification(notification: Notification)
    {
        guard let userInfo = notification.userInfo,
            let success  = userInfo["success"] as? Bool else {
                print("No userInfo found in notification")
                return
        }
        if success
        {
            AppDelegate.user.lastname = userInfo["lastname"] as? String
            AppDelegate.user.skill = userInfo["skill"] as? String
            AppDelegate.user.name = userInfo["name"] as? String
            AppDelegate.user.role = userInfo["role"] as? String
            AppDelegate.user.isAvailable = (userInfo["isAvailable"] as? Bool)!
        }
        successShow(success)
    }
    
    func successShow(_ success: Bool){
        if success
        {
            DispatchQueue.main.sync {
                let viewController = PushViewController()
                AppDelegate.pc = viewController
                navigationController?.pushViewController(viewController ,animated: true)
                btnLogin.isEnabled = true
            }
        }
        else
        {
            DispatchQueue.main.sync {
                let alert = UIAlertController(title: "Error", message: "Invalid username or password", preferredStyle: UIAlertControllerStyle.alert)
                alert.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
                self.present(alert, animated: true, completion: nil)
                btnLogin.isEnabled = true
            }
        }
    }
    
    func dismissKeyboard()
    {
        textUsername.resignFirstResponder()
        textPassword.resignFirstResponder()
    }

}
