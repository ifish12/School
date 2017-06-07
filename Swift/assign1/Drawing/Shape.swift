//
//  Shape.swift
//  Drawing
//
//  Created by Chris Chadillon on 2016-02-10.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class Shape: NSObject {
    let X:Double
    let Y:Double
    
    init(X:Double, Y:Double) {
        self.X = X
        self.Y = Y
    }
    
    func draw (contect: CGContext){}
    
    func encodeWithCoder(coder: NSCoder) {}
}
