//
//  MenuViewCell.swift
//  HGSS
//
//  Created by Five on 17/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit

class MenuViewCell: UITableViewCell {

    
    @IBOutlet weak var imgMenu: UIImageView!
    @IBOutlet weak var lblMenu: UILabel!

    override func setSelected(_ selected: Bool, animated: Bool)
    {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func set(text: String)
    {
        lblMenu.text = text
        imgMenu.image = UIImage(named: text)
    }
    
}
