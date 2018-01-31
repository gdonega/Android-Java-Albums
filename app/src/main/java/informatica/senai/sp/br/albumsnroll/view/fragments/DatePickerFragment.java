package informatica.senai.sp.br.albumsnroll.view.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by gustavo on 25/01/2018.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    /*Instances*/
    private Calendar calendar;
    private int editTextID;
    private static DateFormat fmt = DateFormat.getDateInstance(DateFormat.LONG);


    public static DatePickerFragment dateSetDialog (Calendar calendar, int editTextID){
        DatePickerFragment instance = new DatePickerFragment();
        instance.calendar = calendar;
        instance.editTextID = editTextID;
        return instance;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (calendar == null){
            long cal = savedInstanceState.getLong("cal");
            editTextID = savedInstanceState.getInt("edit");

            calendar = Calendar.getInstance();
            calendar.setTimeInMillis(cal);
        }
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, dayOfMonth);
        return dialog;

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(year, month, dayOfMonth);
        EditText editText = getActivity().findViewById(editTextID);
        editText.setText(fmt.format(calendar.getTime()));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("edit", editTextID);
        outState.putLong("cal", calendar.getTimeInMillis());
        super.onSaveInstanceState(outState);
    }
}
