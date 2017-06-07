//
//  Rect.swift
//  Drawing
//
//  Created by Chris Chadillon on 2016-02-10.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class Rect:Shape {
    
    override func draw(context: CGContext) {
        let rect = CGRect(x: self.X, y: self.Y, width: self.Width, height: self.Height)
        let linewidth = CGFloat(self.Style.LineWidth)
        CGContextSetLineWidth(context, linewidth)
        let colorSpace = CGColorSpaceCreateDeviceRGB()
        
        let LineRGBO: [CGFloat] = self.Style.LineColor
        let FillRGBO: [CGFloat] = self.Style.FillColor
        
        let Linecolor = CGColorCreate(colorSpace, LineRGBO)
        let Fillcolor = CGColorCreate(colorSpace, FillRGBO)
        
        CGContextSetStrokeColorWithColor(context, Linecolor)
        CGContextSetFillColorWithColor(context, Fillcolor)
        if(self.Style.Filled){
            CGContextAddRect(context, rect);
            CGContextFillPath(context)
        }
        CGContextAddRect(context, rect);
        CGContextStrokePath(context);
    }
}
