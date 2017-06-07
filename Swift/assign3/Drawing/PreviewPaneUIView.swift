//
//  PreviewView.swift
//  Drawing
//
//  Created by Shapiro, Geoff on 2016-02-25.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class PreviewPaneUIView: UIView {
    var myParent : OptionsUIViewController!
    
    override func drawRect(rect: CGRect) {
        
        
        let context = UIGraphicsGetCurrentContext()
        let linewidth = CGFloat((myParent?.LineWidth.value)!)
        CGContextSetLineWidth(context, linewidth)
        let colorSpace = CGColorSpaceCreateDeviceRGB()
        var LineRGBO: [CGFloat] = [0.0, 0.0, 0.0, 1.0]
        var FillRGBO: [CGFloat] = [0.0, 0.0, 0.0, 1.0]
        
        let LineColorString = myParent.LineColor.titleForSegmentAtIndex(myParent.LineColor.selectedSegmentIndex)
        
        let FillColorString = myParent.FillColor.titleForSegmentAtIndex(myParent.FillColor.selectedSegmentIndex)
        
        
        LineRGBO = getRGBfromString(LineColorString);
        
        
        
        FillRGBO = getRGBfromString(FillColorString);
        
        
        
        let Linecolor = CGColorCreate(colorSpace, LineRGBO)
        let Fillcolor = CGColorCreate(colorSpace, FillRGBO)
        
        CGContextSetStrokeColorWithColor(context, Linecolor)
        CGContextSetFillColorWithColor(context, Fillcolor)
        
        
        
        
        
        let width = self.bounds.size.width - 80
        let height = self.bounds.size.height - 80
        let previewX = self.bounds.minX + 40
        let previewY = self.bounds.minY + 40
        
        

        let previewRect = CGRect(x: previewX, y: previewY, width: width, height: height)
        
        
        
        if(myParent.FilledSwitch.on){
            if(myParent.displayshape == 0){
                CGContextAddRect(context, previewRect);
            }
            if(myParent.displayshape == 1){
                CGContextAddEllipseInRect(context, previewRect)
            }
            
            CGContextFillPath(context)
            
        }
        if(myParent.displayshape == 0){
        CGContextAddRect(context, previewRect);
        }
        if(myParent.displayshape == 1){
            CGContextAddEllipseInRect(context, previewRect)
        }
        if(myParent.displayshape == 2){
            CGContextMoveToPoint(context, CGFloat(previewX), CGFloat(previewY))
            CGContextAddLineToPoint(context, CGFloat(width + previewX), CGFloat(height + previewY))
        }
        CGContextStrokePath(context);
        
    }
    
    func getRGBfromString(colorString: String?) -> [CGFloat] {
        var components: [CGFloat] = [0.0, 0.0, 1.0, 1.0]
        switch colorString {
        case "Red"?:
            components = [1.0, 0.0, 0.0, 1.0]
        case "Green"?:
            components = [0.0, 1.0, 0.0, 1.0]
        case "Blue"?:
            components = [0.0, 0.0, 1.0, 1.0]
        case "Yellow"?:
            components = [1.0, 1.0, 0.0, 1.0]
        case "Pink"?:
            components = [1.0, 0.45, 0.60, 1.0]
        case "Black"?:
            components = [0.0, 0.0, 0.0, 1.0]
        default:
            components = [0.0, 0.0, 0.0, 1.0]
        }
        return components;
    }



}
