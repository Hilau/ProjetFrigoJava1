package View;

import Model.Model;

public interface Observer
{
    public void update(String str, Model model);
}
