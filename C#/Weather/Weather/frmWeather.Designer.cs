namespace Weather
{
    partial class frmWeather
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
            this.lblNumVa = new System.Windows.Forms.Label();
            this.txtNumval = new System.Windows.Forms.TextBox();
            this.btnFar = new System.Windows.Forms.Button();
            this.btnCelcius = new System.Windows.Forms.Button();
            this.lblOutput = new System.Windows.Forms.Label();
            this.btnClr = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lblNumVa
            // 
            this.lblNumVa.AutoSize = true;
            this.lblNumVa.Location = new System.Drawing.Point(12, 19);
            this.lblNumVa.Name = "lblNumVa";
            this.lblNumVa.Size = new System.Drawing.Size(101, 13);
            this.lblNumVa.TabIndex = 0;
            this.lblNumVa.Text = "Enter numeric value";
            // 
            // txtNumval
            // 
            this.txtNumval.Location = new System.Drawing.Point(290, 19);
            this.txtNumval.Name = "txtNumval";
            this.txtNumval.Size = new System.Drawing.Size(100, 20);
            this.txtNumval.TabIndex = 1;
            this.txtNumval.TextChanged += new System.EventHandler(this.txtNumval_TextChanged);
            // 
            // btnFar
            // 
            this.btnFar.Location = new System.Drawing.Point(15, 255);
            this.btnFar.Name = "btnFar";
            this.btnFar.Size = new System.Drawing.Size(121, 45);
            this.btnFar.TabIndex = 2;
            this.btnFar.Text = "Convert to Farenheit";
            this.btnFar.UseVisualStyleBackColor = true;
            this.btnFar.Click += new System.EventHandler(this.btnFar_Click);
            // 
            // btnCelcius
            // 
            this.btnCelcius.Location = new System.Drawing.Point(290, 255);
            this.btnCelcius.Name = "btnCelcius";
            this.btnCelcius.Size = new System.Drawing.Size(100, 45);
            this.btnCelcius.TabIndex = 3;
            this.btnCelcius.Text = "Convert to Celciuisd";
            this.btnCelcius.UseVisualStyleBackColor = true;
            this.btnCelcius.Click += new System.EventHandler(this.btnCelcius_Click);
            // 
            // lblOutput
            // 
            this.lblOutput.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblOutput.Location = new System.Drawing.Point(152, 296);
            this.lblOutput.Name = "lblOutput";
            this.lblOutput.Size = new System.Drawing.Size(123, 47);
            this.lblOutput.TabIndex = 4;
            // 
            // btnClr
            // 
            this.btnClr.Location = new System.Drawing.Point(15, 317);
            this.btnClr.Name = "btnClr";
            this.btnClr.Size = new System.Drawing.Size(75, 23);
            this.btnClr.TabIndex = 5;
            this.btnClr.Text = "Clr";
            this.btnClr.UseVisualStyleBackColor = true;
            this.btnClr.Click += new System.EventHandler(this.btnClr_Click);
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(300, 316);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(75, 23);
            this.btnExit.TabIndex = 6;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // frmWeather
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(412, 352);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnClr);
            this.Controls.Add(this.lblOutput);
            this.Controls.Add(this.btnCelcius);
            this.Controls.Add(this.btnFar);
            this.Controls.Add(this.txtNumval);
            this.Controls.Add(this.lblNumVa);
            this.Name = "frmWeather";
            this.Text = "Weather";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblNumVa;
        private System.Windows.Forms.TextBox txtNumval;
        private System.Windows.Forms.Button btnFar;
        private System.Windows.Forms.Button btnCelcius;
        private System.Windows.Forms.Label lblOutput;
        private System.Windows.Forms.Button btnClr;
        private System.Windows.Forms.Button btnExit;
    }
}

