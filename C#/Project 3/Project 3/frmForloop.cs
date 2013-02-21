using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Project_3
{
    public partial class frmForloop : Form
    {
        public frmForloop()
        {
            InitializeComponent();
        }

        private void btnGo_Click(object sender, EventArgs e)
        {
           int inbox = 0;

           if (int.TryParse(txtNumbTimes.Text, out inbox))
           {
               for (int count = 1; count <= inbox; count ++)
               {
                   lst1.Items.Add("The number is " + count.ToString());
               }
           }
        }
    }
}
