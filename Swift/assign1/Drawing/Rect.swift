//
//  Rect.swift
//  Drawing
//
//  Created by Chris Chadillon on 2016-02-10.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class Rect:Shape, NSCoding {
    let Height:Double
    let Width:Double
    
    init(X: Double, Y: Double, Height: Double, Width: Double) {
        self.Height = Height
        self.Width = Width
        super.init(X: X, Y: Y)
    }
    
    override func draw(context: CGContext) {
        let rect = CGRect(x: self.X, y: self.Y, width: self.Width, height: self.Height)
        CGContextAddRect(context, rect)
    }
    
    required convenience init?(coder decoder: NSCoder) {
        self.init(
            X: decoder.decodeDoubleForKey("X"),
            Y: decoder.decodeDoubleForKey("Y"),
            Height: decoder.decodeDoubleForKey("Height"),
            Width: decoder.decodeDoubleForKey("Width")
        )
    }
    
    override func encodeWithCoder(coder: NSCoder) {
        coder.encodeDouble(self.X, forKey: "X")
        coder.encodeDouble(self.Y, forKey: "Y")
        coder.encodeDouble(self.Height, forKey: "Height")
        coder.encodeDouble(self.Width, forKey: "Width")
       
    }
}
