namespace Billboard
{
    partial class frmListBox
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
            this.listBox1 = new System.Windows.Forms.ListBox();
            this.btnGo = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.lblArtist = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.lblCurList = new System.Windows.Forms.Label();
            this.lblPrevList = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.lblAvgList = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // listBox1
            // 
            this.listBox1.FormattingEnabled = true;
            this.listBox1.Location = new System.Drawing.Point(13, 13);
            this.listBox1.Name = "listBox1";
            this.listBox1.Size = new System.Drawing.Size(214, 173);
            this.listBox1.TabIndex = 0;
            this.listBox1.SelectedIndexChanged += new System.EventHandler(this.listBox1_SelectedIndexChanged);
            // 
            // btnGo
            // 
            this.btnGo.Location = new System.Drawing.Point(233, 12);
            this.btnGo.Name = "btnGo";
            this.btnGo.Size = new System.Drawing.Size(75, 23);
            this.btnGo.TabIndex = 1;
            this.btnGo.Text = "Fill";
            this.btnGo.UseVisualStyleBackColor = true;
            this.btnGo.Click += new System.EventHandler(this.btnGo_Click);
            // 
            // label1
            // 
            this.label1.Location = new System.Drawing.Point(13, 195);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(100, 23);
            this.label1.TabIndex = 2;
            this.label1.Text = "Artist";
            // 
            // lblArtist
            // 
            this.lblArtist.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.lblArtist.Location = new System.Drawing.Point(13, 218);
            this.lblArtist.Name = "lblArtist";
            this.lblArtist.Size = new System.Drawing.Size(152, 23);
            this.lblArtist.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.Location = new System.Drawing.Point(171, 195);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(78, 23);
            this.label2.TabIndex = 4;
            this.label2.Text = "Current Listing";
            // 
            // lblCurList
            // 
            this.lblCurList.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.lblCurList.Location = new System.Drawing.Point(174, 218);
            this.lblCurList.Name = "lblCurList";
            this.lblCurList.Size = new System.Drawing.Size(39, 23);
            this.lblCurList.TabIndex = 5;
            // 
            // lblPrevList
            // 
            this.lblPrevList.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.lblPrevList.Location = new System.Drawing.Point(258, 218);
            this.lblPrevList.Name = "lblPrevList";
            this.lblPrevList.Size = new System.Drawing.Size(39, 23);
            this.lblPrevList.TabIndex = 7;
            // 
            // label4
            // 
            this.label4.Location = new System.Drawing.Point(255, 195);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(87, 23);
            this.label4.TabIndex = 6;
            this.label4.Text = "Previous Listing";
            // 
            // lblAvgList
            // 
            this.lblAvgList.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.lblAvgList.Location = new System.Drawing.Point(351, 218);
            this.lblAvgList.Name = "lblAvgList";
            this.lblAvgList.Size = new System.Drawing.Size(39, 23);
            this.lblAvgList.TabIndex = 9;
            // 
            // label5
            // 
            this.label5.Location = new System.Drawing.Point(348, 195);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(93, 23);
            this.label5.TabIndex = 8;
            this.label5.Text = "Average Listing";
            // 
            // frmListBox
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(430, 255);
            this.Controls.Add(this.lblAvgList);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.lblPrevList);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.lblCurList);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.lblArtist);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnGo);
            this.Controls.Add(this.listBox1);
            this.Name = "frmListBox";
            this.Text = "Top 10 music chart";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListBox listBox1;
        private System.Windows.Forms.Button btnGo;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblArtist;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label lblCurList;
        private System.Windows.Forms.Label lblPrevList;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label lblAvgList;
        private System.Windows.Forms.Label label5;
    }
}