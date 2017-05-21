//
//  Constatnts.swift
//  HGSS
//
//  Created by Five on 17/05/2017.
//  Copyright © 2017 Five. All rights reserved.
//

import Foundation

struct Constants
{
    static let nibMenuCell = "MenuViewCell"
    static let nibMeberCell = "MemberTableViewCell"
    static let nibHederCell = "HederViewCell"
    static let actionCell = "ActionsViewCell"
    static let nibMainCollCell = "MainCollectionViewCell"
    static let mainSection = ["Penjanje", "Planinarenje", "Savjeti za visoka brda", "Sigurnosna pravila HGSS", "Planinarenje", "Savjeti za visoka brda"]
    static let locationClassName = String(describing: Location.self)
    static let userClassName = String(describing: User.self)
    static let pathClassName = String(describing: Path.self)
    //static let loginUrl = "http://demo9819828.mockable.io/mobile/login"
    //static let initActionUrl = "http://demo9819828.mockable.io/initaction"
    //static let getActionsUrl = "http://demo9819828.mockable.io/getactions"
    //static let getActionUrl = "http://demo9819828.mockable.io/getaction/"

    static let items = ["Naslovna", "Nova akcija", "Trenutne akcije", "Lokacija","SOS"]
   
    static let avaliableUrl = "http://192.168.201.182:9000/available"
    static let loginUrl = "http://192.168.201.182:9000/login"
    static let initActionUrl = "http://192.168.201.182:9000/initaction"
    static let goActionUrl = "http://192.168.201.182:9000/addforaction"
    static let getActionsUrl = "http://192.168.201.182:9000/getactions"
    static let getActionUrl = "http://192.168.201.182:9000/getaction/"
    static let joinActionUrl = "http://192.168.201.182:9000/joinaction"
    static let updateAction = "http://192.168.201.182:9000/updateaction/"
    static let sendLocation = "http://192.168.201.182:9000/sendlocation"
    static let sendMsg = "http://192.168.201.182:9000/saveMessage/"
    static let listMsg = "http://192.168.201.182:9000/listMessages/"


}
