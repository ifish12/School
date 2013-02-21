using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Weather
{
    public partial class frmRadioCheck : Form
    {
        public frmRadioCheck()
        {
            InitializeComponent();
        }

        private void chkCart_CheckedChanged(object sender, EventArgs e)
        {
            if(chkCart.Checked)
             picCart.Visible = true;
                else
                picCart.Visible = false;

        }

        private void chkChe_CheckedChanged(object sender, EventArgs e)
        {
            if (chkChe.Checked)
                picChe.Visible = true;
            else
                picChe.Visible = false;
        }

        private void chkBart_CheckedChanged(object sender, EventArgs e)
        {
            if (chkBart.Checked)
                picBart.Visible = true;
            else
                picBart.Visible = false;
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }

   

        private void groupBox1_Enter(object sender, EventArgs e)
        {
           
        }

        private void radBlue_CheckedChanged(object sender, EventArgs e)
        {
            panel1.BackColor = Color.Blue;
        }

        private void radRed_CheckedChanged(object sender, EventArgs e)
        {
            panel1.BackColor = Color.Red;
        }

        private void radGreen_CheckedChanged(object sender, EventArgs e)
        {
            panel1.BackColor = Color.Green;
        }

        private void btnClr_Click(object sender, EventArgs e)
        {
            radDummy.Checked = true;
            panel1.BackColor = DefaultBackColor;

        }
    }
}
