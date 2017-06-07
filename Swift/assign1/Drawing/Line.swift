//
//  Line.swift
//  Drawing
//
//  Created by Shapiro, Geoff on 2016-02-12.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class Line:Shape, NSCoding {
    let X2:CGFloat
    let Y2:CGFloat
    
    init(X: Double, Y: Double, X2: CGFloat, Y2: CGFloat){
        self.X2 = X2
        self.Y2 = Y2
        super.init(X: X, Y: Y)
    }
    
    
    required convenience init?(coder decoder: NSCoder) {
        guard let X2 = decoder.decodeObjectForKey("X2") as? CGFloat,
            let Y2 = decoder.decodeObjectForKey("Y2") as? CGFloat
            else {return nil}
        
        self.init(
            X: decoder.decodeDoubleForKey("X"),
            Y: decoder.decodeDoubleForKey("Y"),
            X2: X2,
            Y2: Y2
        )
    }
    override func encodeWithCoder(coder: NSCoder) {
        coder.encodeDouble(self.X, forKey: "X")
        coder.encodeDouble(self.Y, forKey: "Y")
        coder.encodeObject(self.X2, forKey: "X2")
        coder.encodeObject(self.Y2, forKey: "Y2")
    }
    
    override func draw(context: CGContext) {
        CGContextMoveToPoint(context, CGFloat(X), CGFloat(Y))
        CGContextAddLineToPoint(context, self.X2, self.Y2)
    }
}
