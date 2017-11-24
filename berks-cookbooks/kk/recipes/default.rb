
# Cookbook Name:: kk-
# Recipe:: default
#
# Copyright (C) 2017 
#
    s3_file "/home/ec2-user/Mycode.jar" do
        remote_path "Mycode.jar"
        bucket "jenkinsbucket123"
        s3_url "https://s3-eu-west-1.amazonaws.com/jenkinsbucket123"
        action :create
    end


execute "running Mycode" do
  command "java -jar /home/ec2-user/Mycode.jar >> output.txt"
  cwd "/home/ec2-user"
  action "run"
end

execute "copying output file to s3" do
command "aws s3 cp /home/ec2-user/output.txt s3://myautomationscailing/myfolder/output.txt"
 action "run"
end

bash "running bash script" do
code 'FILE="output.txt"; if [ -f "/home/ec2-user/$FILE" ];  then NOW=$(date +"%c");  echo "Current time : $NOW", `curl http://169.254.169.254/latest/meta-data/instance-id`, "created successfully" >> /home/ec2-user/output.txt ; else echo "File $FILE does not exist";  fi'
end

execute "download file from  s3" do
command "aws s3 cp s3://myautomationscailing/myfolder/newfile.txt  /home/ec2-user/newfile.txt"
 action "run"
end



execute "give permmission" do
command "sudo chmod 777 /home/ec2-user/newfile.txt"
 action "run"
end


execute "copy details" do
command "cat /home/ec2-user/output.txt >> /home/ec2-user/newfile.txt"
 action "run"
end

execute "upload new file with details " do
command "aws s3 cp /home/ec2-user/newfile.txt s3://myautomationscailing/myfolder/newfile.txt"
 action "run"
end
