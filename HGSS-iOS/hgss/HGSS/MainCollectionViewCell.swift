//
//  MainCollectionViewCell.swift
//  HGSS
//
//  Created by Five on 19/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import UIKit

class MainCollectionViewCell: UICollectionViewCell {

    @IBOutlet weak var imageView: UIImageView!
    
    func setup(imageName: String)  {
        
        self.backgroundColor = UIColor.white
        let image = UIImage(named: imageName)
        imageView.image = image
    }


}
