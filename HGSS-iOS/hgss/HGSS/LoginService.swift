//
//  LoginService.swift
//  HGSS
//
//  Created by Five on 20/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import Foundation

class LoginService
{
    let ns = NetworkService()
    
    func loginPost(username: String, password: String) {
        let url: URL = URL(string: Constants.loginUrl)!
        let dict = ["username": username, "password":password] as [String: Any]
        let jsonData = try? JSONSerialization.data(withJSONObject: dict, options: .prettyPrinted)
        var request = URLRequest(url: url)
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        request.httpMethod = "POST"
        request.httpBody = jsonData
        let task = URLSession.shared.dataTask(with: request , completionHandler:{
            (data, response, error) in
            if error != nil
            {
                print(error!.localizedDescription)
            }
            else
            {
                do
                {

                    if (response as! HTTPURLResponse).statusCode == 200
                    {
                        guard let json = try JSONSerialization.jsonObject(with: data!, options: .allowFragments) as? [String: Any]
                            else
                        {
                            return
                        }
                        let name = json["firstName"] as! String
                        let lastname = json["lastName"] as! String
                        let skillTmp = json["skill"] as! [String: Any]
                        let skil = skillTmp["skill"] as! String
                        let roleTmp = json["role"] as! [String: Any]
                        let role = roleTmp["role"] as! String
                        let isAva = json["isAvailable"] as! Bool
                        AppDelegate.user = DatabaseController.getUser(username: username)
                        NotificationCenter.default.post(name:Notification.Name(rawValue:"LoginSuccess"),
                                                        object: nil,
                                                        userInfo: ["success":true, "name": name, "role": role, "skill": skil, "lastname": lastname, "isAvailable": isAva])
                    }
                    else
                    {
                        NotificationCenter.default.post(name:Notification.Name(rawValue:"LoginSuccess"),
                                                        object: nil,
                                                        userInfo: ["success":false])
                    }
                }
                catch (let error)
                {
                    print("error in JSONSerialization: \(error)")
                }
            }
        })
        task.resume()
    }
}
