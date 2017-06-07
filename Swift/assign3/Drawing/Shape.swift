//
//  Shape.swift
//  Drawing
//
//  Created by Chris Chadillon on 2016-02-10.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class Shape : NSObject {
    var X:Double
    var Y:Double
    var Height:Double
    var Width:Double
    var Style:Options
    
    init(X:Double, Y:Double, Style:Options, Height:Double, Width:Double) {
        self.X = X
        self.Y = Y
        self.Height = Height
        self.Width = Width
        self.Style = Style
    }
    
    func draw (context: CGContext){}
    
    required init(coder aDecoder: NSCoder) {
        let X = aDecoder.decodeDoubleForKey("X")
        self.X = X
        let Y = aDecoder.decodeDoubleForKey("Y")
        self.Y = Y
        let Style = aDecoder.decodeObjectForKey("Style")
        let H = aDecoder.decodeDoubleForKey("H")
        self.Height = H
        let W = aDecoder.decodeDoubleForKey("W")
        self.Width = W

        self.Style = Style as! Options
        
    }
    
    func encodeWithCoder(aCoder: NSCoder) {
        aCoder.encodeDouble(X, forKey: "X")
        aCoder.encodeDouble(Y, forKey: "Y")
        aCoder.encodeObject(Style, forKey: "Style")
        aCoder.encodeDouble(Height, forKey: "H")
        aCoder.encodeDouble(Width, forKey: "W")
        
    }
    
    func contains(point: CGPoint) -> Bool{
        if(CGRectContainsPoint(CGRect(x: X, y: Y, width: Width, height: Height), point)){
            return true;
        }
 
        return false;
    }

}
