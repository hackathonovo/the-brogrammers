//
//  AdviceViewController.swift
//  HGSS
//
//  Created by Five on 19/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit

class AdviceViewController: UIViewController
{


    @IBOutlet weak var lblTitle: UILabel!
    @IBOutlet weak var textView: UITextView!
    var titleText = "Title"
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        lblTitle.text = titleText
        textView.isEditable = false
    }
    
    init(title: String) {
        super.init(nibName: String(describing: AdviceViewController.self), bundle: nil)
        self.titleText = title
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    @IBAction func back(_ sender: Any)
    {
        navigationController?.popViewController(animated: true)
    }

}

