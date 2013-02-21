namespace Project_3
{
    partial class frmForloop
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
            this.lst1 = new System.Windows.Forms.ListBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtNumbTimes = new System.Windows.Forms.TextBox();
            this.btnGo = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lst1
            // 
            this.lst1.FormattingEnabled = true;
            this.lst1.Location = new System.Drawing.Point(13, 13);
            this.lst1.Name = "lst1";
            this.lst1.Size = new System.Drawing.Size(180, 95);
            this.lst1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(20, 120);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(84, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "How many times";
            // 
            // txtNumbTimes
            // 
            this.txtNumbTimes.Location = new System.Drawing.Point(23, 149);
            this.txtNumbTimes.Name = "txtNumbTimes";
            this.txtNumbTimes.Size = new System.Drawing.Size(100, 20);
            this.txtNumbTimes.TabIndex = 2;
            // 
            // btnGo
            // 
            this.btnGo.Location = new System.Drawing.Point(152, 135);
            this.btnGo.Name = "btnGo";
            this.btnGo.Size = new System.Drawing.Size(41, 34);
            this.btnGo.TabIndex = 3;
            this.btnGo.Text = "go";
            this.btnGo.UseVisualStyleBackColor = true;
            this.btnGo.Click += new System.EventHandler(this.btnGo_Click);
            // 
            // frmForloop
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(214, 188);
            this.Controls.Add(this.btnGo);
            this.Controls.Add(this.txtNumbTimes);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lst1);
            this.Name = "frmForloop";
            this.Text = "frmForloop";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox lst1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtNumbTimes;
        private System.Windows.Forms.Button btnGo;
    }
}