//
//  PageViewController.swift
//  HGSS
//
//  Created by Five on 19/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit

class PageViewController: UIViewController {

    @IBOutlet weak var textView: UITextView!
    override func viewDidLoad() {
        super.viewDidLoad()
        textView.isEditable = false
        textView.backgroundColor = .green
    }

}
