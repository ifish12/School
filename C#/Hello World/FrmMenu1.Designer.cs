namespace First_Project
{
    partial class FrmMenu1
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
            this.btnHello = new System.Windows.Forms.Button();
            this.btnDate = new System.Windows.Forms.Button();
            this.btncon = new System.Windows.Forms.Button();
            this.btnArea = new System.Windows.Forms.Button();
            this.button5 = new System.Windows.Forms.Button();
            this.button6 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnHello
            // 
            this.btnHello.Location = new System.Drawing.Point(13, 13);
            this.btnHello.Name = "btnHello";
            this.btnHello.Size = new System.Drawing.Size(110, 53);
            this.btnHello.TabIndex = 0;
            this.btnHello.Text = "Hello";
            this.btnHello.UseVisualStyleBackColor = true;
            this.btnHello.Click += new System.EventHandler(this.btnHello_Click);
            // 
            // btnDate
            // 
            this.btnDate.Location = new System.Drawing.Point(13, 72);
            this.btnDate.Name = "btnDate";
            this.btnDate.Size = new System.Drawing.Size(110, 53);
            this.btnDate.TabIndex = 1;
            this.btnDate.Text = "Date";
            this.btnDate.UseVisualStyleBackColor = true;
            this.btnDate.Click += new System.EventHandler(this.btnDate_Click);
            // 
            // btncon
            // 
            this.btncon.Location = new System.Drawing.Point(13, 144);
            this.btncon.Name = "btncon";
            this.btncon.Size = new System.Drawing.Size(110, 47);
            this.btncon.TabIndex = 2;
            this.btncon.Text = "Consume";
            this.btncon.UseVisualStyleBackColor = true;
            this.btncon.Click += new System.EventHandler(this.btncon_Click);
            // 
            // btnArea
            // 
            this.btnArea.Location = new System.Drawing.Point(152, 12);
            this.btnArea.Name = "btnArea";
            this.btnArea.Size = new System.Drawing.Size(95, 54);
            this.btnArea.TabIndex = 3;
            this.btnArea.Text = "Area";
            this.btnArea.UseVisualStyleBackColor = true;
            this.btnArea.Click += new System.EventHandler(this.btnArea_Click);
            // 
            // button5
            // 
            this.button5.Location = new System.Drawing.Point(152, 72);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(95, 53);
            this.button5.TabIndex = 4;
            this.button5.Text = "?";
            this.button5.UseVisualStyleBackColor = true;
            // 
            // button6
            // 
            this.button6.Location = new System.Drawing.Point(152, 144);
            this.button6.Name = "button6";
            this.button6.Size = new System.Drawing.Size(95, 47);
            this.button6.TabIndex = 5;
            this.button6.Text = "?";
            this.button6.UseVisualStyleBackColor = true;
            // 
            // FrmMenu1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.OrangeRed;
            this.ClientSize = new System.Drawing.Size(284, 262);
            this.Controls.Add(this.button6);
            this.Controls.Add(this.button5);
            this.Controls.Add(this.btnArea);
            this.Controls.Add(this.btncon);
            this.Controls.Add(this.btnDate);
            this.Controls.Add(this.btnHello);
            this.Name = "FrmMenu1";
            this.Text = "Menu1";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnHello;
        private System.Windows.Forms.Button btnDate;
        private System.Windows.Forms.Button btncon;
        private System.Windows.Forms.Button btnArea;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.Button button6;
    }
}