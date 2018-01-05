
# Cookbook Name:: BackEnd-
# Recipe:: default
#
# Copyright (C) 2017 
#
execute "download file from s3" do
 command "aws s3 cp s3://#{node['backend']['BucketName']}/BackEnd-0.0.1-SNAPSHOT.jar   /home/ec2-user/BackEnd-0.0.1-SNAPSHOT.jar"
action "run"
end

execute "running BackEnd.jar" do
  command "java -jar /home/ec2-user/BackEnd-0.0.1-SNAPSHOT.jar  6060  #{node['backend']['Hostname']} 5050 "
  cwd "/home/ec2-user"
action "run"
end