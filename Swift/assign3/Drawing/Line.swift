//
//  Line.swift
//  Drawing
//
//  Created by Shapiro, Geoff on 2016-02-12.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class Line:Shape {

    var X2:Double
    var Y2:Double
    
    override init(X: Double, Y: Double, Style:Options, Height: Double, Width: Double) {
        self.X2 = X + Width
        self.Y2 = Y + Height
        super.init(X: X, Y: Y, Style:Style, Height:Height, Width:Width)
        
    }

    required init(coder aDecoder: NSCoder) {
        let X2 = aDecoder.decodeDoubleForKey("X2")
        self.X2 = X2
        let Y2 = aDecoder.decodeDoubleForKey("Y2")
        self.Y2 = Y2
        super.init(coder: aDecoder)
    }
    
    override func encodeWithCoder(aCoder: NSCoder) {
        aCoder.encodeDouble(X2, forKey: "X2")
        aCoder.encodeDouble(Y2, forKey: "Y2")

        super.encodeWithCoder(aCoder)
    }
    
    override func draw(context: CGContext) {
        //super.draw(context)
        CGContextSetLineWidth(context, CGFloat(self.Style.LineWidth))
        let colorSpace = CGColorSpaceCreateDeviceRGB()
        
        let LineRGBO: [CGFloat] = self.Style.LineColor
        
        
        
        
        let Linecolor = CGColorCreate(colorSpace, LineRGBO)
        
        CGContextSetStrokeColorWithColor(context, Linecolor)
        
        CGContextMoveToPoint(context, CGFloat(self.X), CGFloat(self.Y))
        CGContextAddLineToPoint(context, CGFloat(X2), CGFloat(Y2))
        CGContextStrokePath(context);
        
    }
    
    /*override func contains(point: CGPoint) -> Bool{
        
        let y2 = Y+Height;
        let x2 = X+Width;
        
        
        if(Width < 0 && Height < 0){
            
            if((Double(point.x) >= x2 && Double(point.x) <= X) && (Double(point.y) >= y2 && Double(point.y) <= Y) ) {
                return true;
            }        }
        else{
            
            if((Double(point.x) <= x2 && Double(point.x) >= X) && (Double(point.y) <= y2 && Double(point.y) >= Y) ) {
                return true;
            }
        }
        
        
        return false;
    }*/
}

