namespace Project_3
{
    partial class frmWhile
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.txtBal = new System.Windows.Forms.TextBox();
            this.txtNumMonth = new System.Windows.Forms.TextBox();
            this.lstOut = new System.Windows.Forms.ListBox();
            this.label3 = new System.Windows.Forms.Label();
            this.lblOut = new System.Windows.Forms.Label();
            this.btncalc = new System.Windows.Forms.Button();
            this.btnClr = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(31, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(85, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Starting Balance";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(31, 49);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(94, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Number of Months";
            // 
            // txtBal
            // 
            this.txtBal.Location = new System.Drawing.Point(422, 13);
            this.txtBal.Name = "txtBal";
            this.txtBal.Size = new System.Drawing.Size(100, 20);
            this.txtBal.TabIndex = 2;
            // 
            // txtNumMonth
            // 
            this.txtNumMonth.Location = new System.Drawing.Point(422, 49);
            this.txtNumMonth.Name = "txtNumMonth";
            this.txtNumMonth.Size = new System.Drawing.Size(100, 20);
            this.txtNumMonth.TabIndex = 3;
            // 
            // lstOut
            // 
            this.lstOut.FormattingEnabled = true;
            this.lstOut.Location = new System.Drawing.Point(34, 103);
            this.lstOut.Name = "lstOut";
            this.lstOut.Size = new System.Drawing.Size(488, 186);
            this.lstOut.TabIndex = 4;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(43, 324);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(82, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Ending Balance";
            // 
            // lblOut
            // 
            this.lblOut.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblOut.Location = new System.Drawing.Point(422, 314);
            this.lblOut.Name = "lblOut";
            this.lblOut.Size = new System.Drawing.Size(100, 23);
            this.lblOut.TabIndex = 6;
            // 
            // btncalc
            // 
            this.btncalc.Location = new System.Drawing.Point(48, 362);
            this.btncalc.Name = "btncalc";
            this.btncalc.Size = new System.Drawing.Size(75, 23);
            this.btncalc.TabIndex = 7;
            this.btncalc.Text = "Calc";
            this.btncalc.UseVisualStyleBackColor = true;
            this.btncalc.Click += new System.EventHandler(this.btncalc_Click);
            // 
            // btnClr
            // 
            this.btnClr.Location = new System.Drawing.Point(215, 361);
            this.btnClr.Name = "btnClr";
            this.btnClr.Size = new System.Drawing.Size(75, 23);
            this.btnClr.TabIndex = 8;
            this.btnClr.Text = "clear";
            this.btnClr.UseVisualStyleBackColor = true;
            this.btnClr.Click += new System.EventHandler(this.btnClr_Click);
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(447, 361);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(75, 23);
            this.btnExit.TabIndex = 9;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // frmWhile
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(575, 430);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnClr);
            this.Controls.Add(this.btncalc);
            this.Controls.Add(this.lblOut);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.lstOut);
            this.Controls.Add(this.txtNumMonth);
            this.Controls.Add(this.txtBal);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "frmWhile";
            this.Text = "frmWhile";
            this.Load += new System.EventHandler(this.frmWhile_Load);
            this.DoubleClick += new System.EventHandler(this.frmWhile_DoubleClick);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtBal;
        private System.Windows.Forms.TextBox txtNumMonth;
        private System.Windows.Forms.ListBox lstOut;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label lblOut;
        private System.Windows.Forms.Button btncalc;
        private System.Windows.Forms.Button btnClr;
        private System.Windows.Forms.Button btnExit;
    }
}