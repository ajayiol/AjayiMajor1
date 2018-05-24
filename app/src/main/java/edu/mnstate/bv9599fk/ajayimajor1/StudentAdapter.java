package edu.mnstate.bv9599fk.ajayimajor1;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nick_ on 10/18/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StuViewHolder> {
    private List<info> teamRoster;

    public StudentAdapter(List<info> teamRoster) {
        this.teamRoster=teamRoster;
    }

    @Override
    public StuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedVw = LayoutInflater.from(parent.getContext()).inflate(R.layout.ref,parent,false);
        return new StuViewHolder(inflatedVw);
    }

    @Override
    public void onBindViewHolder(StuViewHolder holder, int position) {
        info in = teamRoster.get(position);
        String club  = in.getClub(); String tmpClub = club;
        holder.tvClub.setText(tmpClub);
        holder.tvName.setText(in.getName());
        holder.tvFoot.setText(in.getFoot());
        holder.tvNum.setText(in.getNumber());


    }

    @Override
    public int getItemCount() {
        return teamRoster.size();
    }

    public class StuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvClub,tvName,tvFoot,tvNum;
        public StuViewHolder(View itemView) {
            super(itemView);
            tvClub = (TextView) itemView.findViewById(R.id.txt1);
            tvName = (TextView) itemView.findViewById(R.id.txt2);
            tvFoot = (TextView) itemView.findViewById(R.id.txt3);
            tvNum = (TextView) itemView.findViewById(R.id.txt4);
            itemView.setOnClickListener(this);



        }

        @Override
        public void onClick(View view) {
            Log.d("SelectedItem", tvName.getText().toString());

        }
    }
}
