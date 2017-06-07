//
//  ViewController.swift
//  Drawing
//
//  Created by Chris Chadillon on 2016-02-10.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet var btnErase: UIButton!
    
    @IBOutlet weak var btnLoad: UIButton!
    
    @IBOutlet weak var btnSave: UIButton!
    
    @IBAction func changeShape(sender: UISegmentedControl) {
        drawingView.shapeType = sender.selectedSegmentIndex
    }
    
    @IBAction func erase(sender: UIButton) {
        btnErase.enabled = false;
        btnSave.enabled = false;
        drawingView.shapes.removeAll()
        drawingView.setNeedsDisplay()
    }
    
    @IBAction func load(sender: UIButton) {
        if let data = NSUserDefaults.standardUserDefaults().objectForKey("shapes") as? NSData {
            drawingView.shapes = (NSKeyedUnarchiver.unarchiveObjectWithData(data) as? [Shape])!
            drawingView.setNeedsDisplay()
            btnErase.enabled = true;
        }
    }
    
    @IBAction func save(sender: UIButton) {
        let data = NSKeyedArchiver.archivedDataWithRootObject(drawingView.shapes)
        NSUserDefaults.standardUserDefaults().setObject(data, forKey: "shapes")
        btnLoad.enabled = true
        btnSave.enabled = false;
    }
    
    @IBOutlet var drawingView: DrawingView!
    override func viewDidLoad() {
        super.viewDidLoad()
        drawingView.daddy = self
        if let _ = NSUserDefaults.standardUserDefaults().objectForKey("shapes") as? NSData {
            btnLoad.enabled = true
        }
        
        // Do any additional setup after loading the view, typically from a nib.
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

