//
//  NetworkService.swift
//  HGSS
//
//  Created by Five on 20/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import Foundation
import CoreLocation

class NetworkService
{
    func initAction(location: CLLocationCoordinate2D, desc: String, name: String)
    {
        var users = [User()]
        let lat = location.latitude as! Double
        let long = location.longitude as! Double
        let url: URL = URL(string: Constants.initActionUrl)!
        let dict = ["latitude": lat, "longitude":long, "description": desc, "username": AppDelegate.user.username, "title": name] as [String: Any]
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
                        guard let jsonList = try JSONSerialization.jsonObject(with: data!, options: .allowFragments) as? [[String: Any]]
                            else
                        {
                            fatalError("Bad response")
                            return
                        }
                        for json in jsonList
                        {
                            let user = DatabaseController.getUser(username: json["username"] as! String)
                            user.name = json["firstName"] as? String
                            user.lastname = json["lastName"] as? String
                            user.skill = json["skill"] as? String
                            user.role = json["role"] as? String
                            user.cellNumber = (json["phoneNumber"] as? String)!
                            users.append(user)
                        }
                        NotificationCenter.default.post(name:Notification.Name(rawValue:"ProcedToUsers"),
                                                        object: nil,
                                                        userInfo: ["users": users])
                    }
                    else
                    {
                        fatalError("Bad response")
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
    
    func goAction(usernames: [String])
    {
        let url: URL = URL(string: Constants.goActionUrl)!
        let dict = ["usernames": usernames] as [String: Any]
        let jsonData = try? JSONSerialization.data(withJSONObject: dict, options: .prettyPrinted)
        var request = URLRequest(url: url)
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        request.httpMethod = "POST"
        request.httpBody = jsonData
        let task = URLSession.shared.dataTask(with: request , completionHandler:{_,_,_ in })
        task.resume()
    }
    
    func updateAction(location: CLLocationCoordinate2D, desc: String, name: String, id: Int)
    {
        let lat = location.latitude as! Double
    let long = location.longitude as! Double
    let url: URL = URL(string: Constants.updateAction+"\(id)")!
    let dict = ["latitude": lat, "longitude":long, "description": desc, "username": AppDelegate.user.username, "title": name] as [String: Any]
    let jsonData = try? JSONSerialization.data(withJSONObject: dict, options: .prettyPrinted)
    var request = URLRequest(url: url)
    request.addValue("application/json", forHTTPHeaderField: "Content-Type")
    request.httpMethod = "POST"
    request.httpBody = jsonData
    let task = URLSession.shared.dataTask(with: request , completionHandler:{_,_,_ in })
    task.resume()
    }
    

    
    func changeAva(username: String, isAva: Bool)
    {
        let url: URL = URL(string: Constants.avaliableUrl)!
        let dict = ["username": username, "isAvailable": isAva] as [String: Any]
        let jsonData = try? JSONSerialization.data(withJSONObject: dict, options: .prettyPrinted)
        var request = URLRequest(url: url)
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        request.httpMethod = "POST"
        request.httpBody = jsonData
        let task = URLSession.shared.dataTask(with: request , completionHandler:{_,_,_ in })
        task.resume()
    }
    
    func getActions(username: String)
    {

        let url: URL = URL(string: Constants.getActionsUrl)!
        let dict = ["username": AppDelegate.user.username!] as [String: Any]
        let jsonData = try? JSONSerialization.data(withJSONObject: dict, options: .prettyPrinted)
        var request = URLRequest(url: url)
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        request.httpMethod = "GET"
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
                        guard let jsonList = try JSONSerialization.jsonObject(with: data!, options: .allowFragments) as? [[String: Any]]
                            else
                        {
                            fatalError("Bad response")
                        }
                        AppDelegate.actions.removeAll()
                        for json in jsonList
                        {
                            let id = json["id"] as? Int
                            let title = json["title"] as? String
                            let action = Action(id: id!, nameOfAction: title!)
                            AppDelegate.actions.append(action)
                            NotificationCenter.default.post(name:Notification.Name(rawValue:"Relode"),
                                                            object: nil,
                                                            userInfo: nil)
                        }
                    }
                    else
                    {
                        fatalError("Bad response")
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
    
    func getAction(id: Int)
    {
        
        let url: URL = URL(string: Constants.getActionUrl+"\(id)")!
        var request = URLRequest(url: url)
        request.httpMethod = "GET"
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
                            fatalError("Bad response")
                        }
                            let id = json["id"] as? Int
                            let title = json["title"] as? String
                            let description = json["description"] as? String
                            let owner = json["owner"] as? String
                            let users = json["users"] as? [[String: Any]]
                            var showUsers = [UserShow]()
                            for user in users!
                            {
                                let long = user["locationLong"] as! Double
                                let lat = user["locationLat"] as! Double
                                let username = user["username"] as! String
                                let userShow = UserShow(longitude: long, latitude: lat, username: username)
                                showUsers.append(userShow)
                                
                            }
                            let action = Action(id: id!, nameOfAction: title!)
                            let location = CLLocation(latitude: json["latitude"] as! Double, longitude: json["longitude"] as! Double)
                            action.setUp(owner: owner!, desc: description!, location: location)
                            NotificationCenter.default.post(name:Notification.Name(rawValue:"GoToAction"),
                                                            object: nil,
                                                            userInfo: ["action": action, "users": showUsers])
                        
                    }
                    else
                    {
                        fatalError("Bad response")
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
    
    func join(id: Int)
    {
        let url: URL = URL(string: Constants.joinActionUrl)!
        let dict = ["username": AppDelegate.user.username!, "id": id] as [String: Any]
        let jsonData = try? JSONSerialization.data(withJSONObject: dict, options: .prettyPrinted)
        var request = URLRequest(url: url)
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        request.httpMethod = "POST"
        request.httpBody = jsonData
        let task = URLSession.shared.dataTask(with: request , completionHandler:{_,_,_ in })
        task.resume()
    }
    
    func sendLocation(location: CLLocationCoordinate2D)
    {
        let lat = location.latitude as! Double
        let long = location.longitude as! Double
        let url: URL = URL(string: Constants.sendLocation)!
        let dict = ["latitude": lat, "longitude":long, "username": AppDelegate.user.username] as [String: Any]
        let jsonData = try? JSONSerialization.data(withJSONObject: dict, options: .prettyPrinted)
        var request = URLRequest(url: url)
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        request.httpMethod = "POST"
        request.httpBody = jsonData
        let task = URLSession.shared.dataTask(with: request , completionHandler:{_,_,_ in })
        task.resume()
    }
    
    func sendMsg(txt: String, id: Int)
    {
        let url: URL = URL(string: Constants.sendMsg+"\(id)")!
        let dict = ["username": AppDelegate.user.username, "message": txt] as [String: Any]
        let jsonData = try? JSONSerialization.data(withJSONObject: dict, options: .prettyPrinted)
        var request = URLRequest(url: url)
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        request.httpMethod = "POST"
        request.httpBody = jsonData
        let task = URLSession.shared.dataTask(with: request , completionHandler:{_,_,_ in })
        task.resume()
    }
    
    func getMsg()
    {
        let url: URL = URL(string: Constants.listMsg+"\(AppDelegate.action?.id)")!
        var request = URLRequest(url: url)
        request.httpMethod = "GET"
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
                        guard let jsonList = try JSONSerialization.jsonObject(with: data!, options: .allowFragments) as? [[String: Any]]
                            else
                        {
                            fatalError("Bad response")
                        }
                        var msgs = ""
                        for json in jsonList
                        {
                            let username = json["username"] as! String
                            let message = json["message"] as! String
                            msgs.append(username+":"+message+"\r\n")

                        }
                        NotificationCenter.default.post(name:Notification.Name(rawValue:"relodeMsg"),
                                                        object: nil,
                                                        userInfo: ["msgs": msgs])
                        
                    }
                    else
                    {
                        fatalError("Bad response")
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

