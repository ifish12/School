using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Tic_Tac_Toe
{
    public partial class frmPassword : Form
    {
        int count = 0;
        public frmPassword()
        {
            InitializeComponent();
        }

        private void btnGo_Click(object sender, EventArgs e)
        {
            
            if (count < 5)
            {
                if (textBox1.Text == "Password")
                {
                    frmTac itsybitsyspider = new frmTac();
                    itsybitsyspider.Show();
                    

                }
                else
                {
                    MessageBox.Show("Wrong password!");
                    count++;
                }
            }
            else
                MessageBox.Show("You've tried too many times(the max is 5)");
        }
    }
}
