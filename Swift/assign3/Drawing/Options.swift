//
//  Options.swift
//  Drawing
//
//  Created by Shapiro, Geoff on 2016-02-25.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class Options : NSObject {
    var LineWidth:Double
    var LineColor:[CGFloat]
    var Filled:Bool
    var FillColor:[CGFloat]
    
    init(LineWidth:Double, LineColor:[CGFloat], Filled:Bool, FillColor:[CGFloat]) {
        self.LineWidth = LineWidth
        self.LineColor = LineColor
        self.Filled = Filled
        self.FillColor = FillColor
    }
    
    override init() {
        self.LineWidth = 1
        self.LineColor = [0.0, 0.0, 0.0, 1.0]
        self.Filled = true
        self.FillColor = [1.0, 1.0, 1.0, 1.0]
    }
    
    required init(coder aDecoder: NSCoder) {
        let LineWidth = aDecoder.decodeDoubleForKey("LineWidth")
        self.LineWidth = LineWidth
        let LineColor = aDecoder.decodeObjectForKey("LineColor")
        self.LineColor = LineColor as! [CGFloat]
        let Filled = aDecoder.decodeBoolForKey("Filled")
        self.Filled = Filled
        let FillColor = aDecoder.decodeObjectForKey("FillColor")
        self.FillColor = FillColor as! [CGFloat]
        
    }
    
    func encodeWithCoder(aCoder: NSCoder) {
        aCoder.encodeDouble(LineWidth, forKey: "LineWidth")
        aCoder.encodeObject(LineColor, forKey: "LineColor")
        aCoder.encodeObject(FillColor, forKey: "FillColor")
        aCoder.encodeBool(Filled, forKey: "Filled")
        
    }
    
}
