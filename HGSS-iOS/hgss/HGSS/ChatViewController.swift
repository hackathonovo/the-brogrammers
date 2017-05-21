//
//  ChatViewController.swift
//  HGSS
//
//  Created by Five on 21/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit
import Foundation
import SocketIO

class ChatViewController: UIViewController
{
    @IBOutlet weak var inputText: UITextView!

    @IBOutlet weak var constraint: NSLayoutConstraint!
   
    @IBOutlet weak var showMsg: UITextView!
    let ns = NetworkService()
    let nc = NotificationCenter.default

    @IBAction func sendMessage(_ sender: Any)
    {
        ns.sendMsg(txt: inputText.text, id: (AppDelegate.action?.id)!)
        showMsg.text.append("\r\n"+AppDelegate.user.username!+":"+inputText.text)
        inputText.text = "Unesi poruku..."
    }
    
    override func viewDidLoad()
    {
        showMsg.isEditable = false
        inputText.delegate = self
        inputText.textColor = .lightGray
        inputText.text = "Unesi poruku..."
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        showMsg.addGestureRecognizer(tap)
        nc.addObserver(forName:Notification.Name(rawValue:"relodeMsg"),
                       object:nil, queue:nil,
                       using:relodeMsg)
    }
    
    func relodeMsg(notification: Notification){
        guard let userInfo = notification.userInfo,
            let msgs  = userInfo["msgs"] as? String else
        {
                print("No userInfo found in notification")
                return
        }
        DispatchQueue.main.sync {
            showMsg.text = msgs
        }
    }
    
    func dismissKeyboard()
    {
        inputText.resignFirstResponder()
    }
}

extension ChatViewController: UITextViewDelegate
{
    func textViewDidBeginEditing(_ textView: UITextView)
    {
        constraint.constant += 200
        if textView.text == "Unesi poruku..."
        {
            textView.text = ""
            textView.textColor = .black
        }
        textView.becomeFirstResponder() //Optional
    }
    
    func textViewDidEndEditing(_ textView: UITextView)
    {
        constraint.constant -= 200
        if textView.text == ""
        {
            textView.text = "Unesi poruku..."
            textView.textColor = .lightGray
        }
        textView.resignFirstResponder()
    }
}
