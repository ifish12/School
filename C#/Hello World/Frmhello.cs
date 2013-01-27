using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace First_Project
{
    public partial class Frmhello : Form
    {
        public Frmhello()
        {
            InitializeComponent();
        }

        private void btnGo_Click(object sender, EventArgs e)
        {
           MessageBox.Show("Super Mega death button initialized!");
          
        }

        private void Frmhello_Load(object sender, EventArgs e)
        {

        }

        private void btnRed_Click(object sender, EventArgs e)
        {
            this.BackColor = Color.Red;
        }

        private void blue_Click(object sender, EventArgs e)
        {
            this.BackColor = Color.Blue;
        }

        private void green_Click(object sender, EventArgs e)
        {
            this.BackColor = Color.Green;
        }
    }
}
