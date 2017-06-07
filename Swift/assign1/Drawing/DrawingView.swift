//
//  DrawingView.swift
//  Drawing
//
//  Created by Chris Chadillon on 2016-02-10.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class DrawingView: UIView {
    
    var daddy:ViewController?
    var shapeType = 0
    var shapes = [Shape]()
    var touchStart:UITouch?
    var touchEnd:UITouch?
    var locationStart:CGPoint?
    var locationEnd:CGPoint?
    
    override func drawRect(rect: CGRect) {
        let context = UIGraphicsGetCurrentContext()
        CGContextSetLineWidth(context, 1.0)
        let colorSpace = CGColorSpaceCreateDeviceRGB()
        let components: [CGFloat] = [0.0, 0.0, 1.0, 1.0]
        let color = CGColorCreate(colorSpace, components)
        CGContextSetStrokeColorWithColor(context, color)
        
        for i in 0..<shapes.count {
            shapes[i].draw(context!)
        }
        
        CGContextStrokePath(context);
        
    }
    
    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
       
        touchStart = touches.first! as UITouch
        locationStart = touchStart!.locationInView(self)
        
    }
    
    override func touchesEnded(touches: Set<UITouch>, withEvent event: UIEvent?) {
        touchEnd = touches.first! as UITouch
        locationEnd = touchEnd!.locationInView(self)
        
        let width = Double(locationEnd!.x - locationStart!.x)
        let height = Double(locationEnd!.y - locationStart!.y)
        
        if shapeType == 0 {
            shapes.append(Rect(X: Double(locationStart!.x), Y: Double(locationStart!.y), Height: height, Width: width))
        }
        else if shapeType == 1{
            shapes.append(Oval(X: Double(locationStart!.x), Y: Double(locationStart!.y), Height: height, Width: width))
        }
        else {
            shapes.append(Line(X: Double(locationStart!.x), Y: Double(locationStart!.y), X2: locationEnd!.x, Y2: locationEnd!.y))
        }
        
        daddy?.btnErase.enabled = true;
        daddy?.btnSave.enabled = true;
        self.setNeedsDisplay()
    }


}
