namespace First_Project
{
    partial class FrmArea
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblLen = new System.Windows.Forms.Label();
            this.lblWid = new System.Windows.Forms.Label();
            this.pan1 = new System.Windows.Forms.Panel();
            this.lblArea = new System.Windows.Forms.Label();
            this.txtLen = new System.Windows.Forms.TextBox();
            this.txtWid = new System.Windows.Forms.TextBox();
            this.lblAreaOut = new System.Windows.Forms.Label();
            this.btnCal = new System.Windows.Forms.Button();
            this.btnClr = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.pan1.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblLen
            // 
            this.lblLen.AutoSize = true;
            this.lblLen.Location = new System.Drawing.Point(30, 26);
            this.lblLen.Name = "lblLen";
            this.lblLen.Size = new System.Drawing.Size(40, 13);
            this.lblLen.TabIndex = 0;
            this.lblLen.Text = "Length";
            // 
            // lblWid
            // 
            this.lblWid.AutoSize = true;
            this.lblWid.Location = new System.Drawing.Point(288, 26);
            this.lblWid.Name = "lblWid";
            this.lblWid.Size = new System.Drawing.Size(35, 13);
            this.lblWid.TabIndex = 1;
            this.lblWid.Text = "Width";
            // 
            // pan1
            // 
            this.pan1.Controls.Add(this.lblAreaOut);
            this.pan1.Controls.Add(this.lblArea);
            this.pan1.Location = new System.Drawing.Point(24, 133);
            this.pan1.Name = "pan1";
            this.pan1.Size = new System.Drawing.Size(332, 114);
            this.pan1.TabIndex = 2;
            // 
            // lblArea
            // 
            this.lblArea.AutoSize = true;
            this.lblArea.Location = new System.Drawing.Point(149, 51);
            this.lblArea.Name = "lblArea";
            this.lblArea.Size = new System.Drawing.Size(29, 13);
            this.lblArea.TabIndex = 0;
            this.lblArea.Text = "Area";
            // 
            // txtLen
            // 
            this.txtLen.Location = new System.Drawing.Point(24, 52);
            this.txtLen.Name = "txtLen";
            this.txtLen.Size = new System.Drawing.Size(100, 20);
            this.txtLen.TabIndex = 3;
            // 
            // txtWid
            // 
            this.txtWid.Location = new System.Drawing.Point(265, 52);
            this.txtWid.Name = "txtWid";
            this.txtWid.Size = new System.Drawing.Size(100, 20);
            this.txtWid.TabIndex = 4;
            // 
            // lblAreaOut
            // 
            this.lblAreaOut.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblAreaOut.Location = new System.Drawing.Point(118, 76);
            this.lblAreaOut.Name = "lblAreaOut";
            this.lblAreaOut.Size = new System.Drawing.Size(100, 23);
            this.lblAreaOut.TabIndex = 1;
            // 
            // btnCal
            // 
            this.btnCal.Location = new System.Drawing.Point(13, 260);
            this.btnCal.Name = "btnCal";
            this.btnCal.Size = new System.Drawing.Size(75, 23);
            this.btnCal.TabIndex = 5;
            this.btnCal.Text = "Calculate";
            this.btnCal.UseVisualStyleBackColor = true;
            this.btnCal.Click += new System.EventHandler(this.btnCal_Click);
            // 
            // btnClr
            // 
            this.btnClr.Location = new System.Drawing.Point(154, 260);
            this.btnClr.Name = "btnClr";
            this.btnClr.Size = new System.Drawing.Size(75, 23);
            this.btnClr.TabIndex = 6;
            this.btnClr.Text = "Clear";
            this.btnClr.UseVisualStyleBackColor = true;
            this.btnClr.Click += new System.EventHandler(this.btnClr_Click);
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(281, 260);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(75, 23);
            this.btnExit.TabIndex = 7;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(154, 91);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(98, 13);
            this.label1.TabIndex = 8;
            this.label1.Text = "IN CENTIMETERS";
            // 
            // FrmArea
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(377, 295);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnClr);
            this.Controls.Add(this.btnCal);
            this.Controls.Add(this.txtWid);
            this.Controls.Add(this.txtLen);
            this.Controls.Add(this.pan1);
            this.Controls.Add(this.lblWid);
            this.Controls.Add(this.lblLen);
            this.Name = "FrmArea";
            this.Text = "FrmArea";
            this.pan1.ResumeLayout(false);
            this.pan1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblLen;
        private System.Windows.Forms.Label lblWid;
        private System.Windows.Forms.Panel pan1;
        private System.Windows.Forms.Label lblArea;
        private System.Windows.Forms.TextBox txtLen;
        private System.Windows.Forms.TextBox txtWid;
        private System.Windows.Forms.Label lblAreaOut;
        private System.Windows.Forms.Button btnCal;
        private System.Windows.Forms.Button btnClr;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.Label label1;
    }
}