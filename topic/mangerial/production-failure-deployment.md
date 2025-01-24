1. Check Deployment Status
   - Kubernetes:
   `kubectl get pods
   kubectl describe pod <pod_name>
   kubectl get deployments`
   - Look for failed pods, crash loops, or errors in the deployment descriptions.
2. GCP Console:
    - Use the GCP Kubernetes Engine dashboard to visually inspect the state of the cluster.
    - Check for any resource issues, such as insufficient CPU or memory.
3. Inspect Logs
    - Kubernetes Logs: Check the logs of the affected pods to see if there are any error messages or stack traces.
      ` kubectl logs <pod_name> -c <container_name>`
    - If necessary, filter logs by severity using tools like grep or use a logging platform.
    - GCP Logging (Cloud Logging - Stack driver):
    - Go to the Google Cloud Logging console and filter the logs for your specific service or pod.
    - Look for error-level logs or warnings that may provide insight into the failure.
    - You can use Log Explorer to search and filter logs by timestamps, severity, and labels.
4. Examine Monitoring Metrics
    - Google Cloud Monitoring:
        - Check Cloud Monitoring to see CPU, memory, disk, and network metrics for your pods,
          nodes, or services.
        - Look for any resource bottlenecks or unusual patterns that could explain the issue.
        - Use custom alerts or predefined ones to spot irregularities.
    - Kubernetes Metrics:
        - Use tools like Prometheus or Grafana (if set up) to visualize key performance indicators (KPIs) of your Kubernetes cluster.
    - Check Health Probes and Service Configurations
    - Liveness and Readiness Probes: Ensure that your liveliness and readiness probes are correctly configured and that they are returning a healthy status.
    - Incorrect probe configurations can result in services not starting properly.
      `           kubectl describe pod <pod_name> | grep 'Liveness\|Readiness'
      `
    - Service Discovery:` kubectl get svc kubectl describe svc <service_name>`
5. Check GCP Cloud Build and Deployment Logs
    - Review the Cloud Build logs to verify if the application was built and deployed without errors.
    - If you’re using a CI/CD pipeline, check the pipeline logs for any issues that might have occurred during deployment.
6. Validate Configuration
    - Ensure that the correct Kubernetes config maps and secrets were deployed with your pods.
    - Double-check environment variables and other settings to verify that they are correct for the production environment.
      `kubectl get configmap <configmap_name>
      kubectl describe secret <secret_name>`
7. Verify Network Connectivity
    - Test network communication between pods and services to ensure they are able to connect as expected.
    - Use tools like kubectl exec to open a shell in the running pods and run commands like curl or ping to check connectivity.
8. Review GCP IAM Permissions and Firewall Rules
    - Ensure that the service accounts have the right IAM permissions to access GCP resources like Cloud Storage, Pub/Sub, or databases.
    - Check firewall rules to ensure the correct traffic is allowed between your services.
9. Check External Dependencies
    - If your application depends on external services (e.g., databases, third-party APIs, message queues), ensure that they are up and running.
    -  Verify that the network routes and authentication (e.g., OAuth, API keys) are working properly.
10. Rollback Deployment (if necessary)
    - If the issue cannot be resolved quickly, you might consider rolling back to the previous stable deployment:
    `kubectl rollout undo deployment <deployment_name>`
